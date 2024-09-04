package atl.classroom.task.crud.demo;

import atl.classroom.task.crud.dao.entity.CardEntity;
import atl.classroom.task.crud.dao.entity.UserEntity;
import atl.classroom.task.crud.dao.repository.CardRepository;
import atl.classroom.task.crud.dao.repository.UserRepository;
import atl.classroom.task.crud.model.enums.CardStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TestTransactionalServiceImpl {
    private final UserRepository userRepository;

    private final CardRepository cardRepository;

    /**
     * TEST 1
     * There is an unchecked exception, so the transaction rolls back, and nothing is written to the database.
     */
    @Transactional
    public void test() {
        saveData();
        throwCustomRuntimeException();
    }

    /**
     * TEST 2
     * There is a checked exception, so the transaction does not roll back, and the part up to the error is written
     * to the database.
     */

    @Transactional
    public void test2() throws Exception {
        userRepository.save(new UserEntity(null, "Mike", "Anders",
                "New York", LocalDate.parse("2002-05-16"), true, null, null,null));

        throwCustomCheckedException();

        cardRepository.save(new CardEntity(null, "4169131331314565", "123", "MIKE ANDERS",
                LocalDate.now(), CardStatus.ACTIVE, null, null,null));

    }

    /**
     * TEST 3
     * If I call this without the @Transactional, rollback will not occur.
     * The reason is that it won't work correctly due to the proxy pattern when called within the same bean.
     */
    public void test3() {
        test();
    }

    /**
     * TEST 4
     * Normally, a transaction only rolls back when an unchecked exception(RuntimeException and its subclasses) occurs.
     * This approach allows checked exceptions to trigger a rollback of the transaction.
     */
    @Transactional(rollbackFor = Exception.class)
    public void test4() throws Exception {
        saveData();
        throwCustomCheckedException();
    }

    /**
     * TEST 5
     * Normally, a transaction will roll back if a RuntimeException or its subclass is thrown.
     * However, by specifying noRollbackFor = RuntimeException.class, you are instructing Spring to not roll back
     * the transaction when a RuntimeException occurs.
     */
    @Transactional(noRollbackFor = RuntimeException.class)
    public void test5() {
        saveData();
        throwCustomRuntimeException();
    }

    /**
     * TEST 6
     */
    @Transactional()
    public void test6() {
        // managed
        var card = cardRepository.findById(1l).get();
        card.setCardHolder("John Doe");

        // new
        var card2 = new CardEntity(null, "4169131331314565", "123", "MIKE ANDERS",
                LocalDate.now(), CardStatus.ACTIVE, null, null, null);
        card2.setCardHolder("Jane Doe");
    }

    private void throwCustomRuntimeException() {
        throw new RuntimeException("CUSTOM_EXCEPTION");
    }

    private void throwCustomCheckedException() throws Exception {
        throw new Exception("CUSTOM_CHECKED_EXCEPTION");
    }

    private void saveData() {
        userRepository.save(new UserEntity(null, "Mike", "Anders",
                "New York", LocalDate.parse("2002-05-16"), true, null, null, null));

        cardRepository.save(new CardEntity(null, "4169131331314565", "123", "MIKE ANDERS",
                LocalDate.now(), CardStatus.ACTIVE, null, null, null));
    }
}
