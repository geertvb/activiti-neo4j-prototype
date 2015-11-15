package be.jdevit.activiti.neo4j.transaction;

import org.activiti.engine.impl.cfg.TransactionContext;
import org.activiti.engine.impl.cfg.TransactionListener;
import org.activiti.engine.impl.cfg.TransactionState;

/**
 * @author Joram Barrez
 */
public class NoopTransactionContext implements TransactionContext {

  public void commit() {
    
  }

  public void rollback() {
    
  }

  public void addTransactionListener(TransactionState transactionState, TransactionListener transactionListener) {
    
  }

}
