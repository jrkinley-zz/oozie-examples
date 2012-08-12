package com.cloudera.examples.oozie.action;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapred.RunningJob;
import org.apache.oozie.action.hadoop.MapReduceMain;

public class CustomLauncher extends MapReduceMain {

  /**
   * To use this class to launch an Oozie action set the
   * "oozie.launcher.action.main.class" property in the workflow configuration
   */
  @Override
  protected RunningJob submitJob(Configuration actionConf) throws Exception {
    return super.submitJob(actionConf);
  }

}
