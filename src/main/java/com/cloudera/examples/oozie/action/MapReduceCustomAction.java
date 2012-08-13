package com.cloudera.examples.oozie.action;

import org.apache.hadoop.fs.FileSystem;
import org.apache.oozie.action.ActionExecutorException;
import org.apache.oozie.action.hadoop.MapReduceActionExecutor;
import org.apache.oozie.client.WorkflowAction;

/**
 * Creates a custom MapReduce action by extending MapReduceActionExecutor
 * http://incubator.apache.org/oozie/docs/3.1.3/docs/DG_CustomActionExecutor.html
 */
public class MapReduceCustomAction extends MapReduceActionExecutor {

  /**
   * You can set "mapred.job.name" by overriding submitLauncher
   */
  @Override
  public void submitLauncher(FileSystem actionFs, Context context,
      WorkflowAction action) throws ActionExecutorException {
    super.submitLauncher(actionFs, context, action);
  }

}
