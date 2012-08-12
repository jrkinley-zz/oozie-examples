package com.cloudera.examples.tests.workflow;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.apache.oozie.cli.OozieCLI;

/**
 * Junit test case to validate the Oozie workflows
 */
public class TestValidWorkflows extends TestCase {
  private static final Logger LOG = Logger.getLogger(TestValidWorkflows.class);
  private static final String WF_BASE_DIR = "src/main/workflow";

  private List<String> workflows = new ArrayList<String>();;

  /**
   * Build list of workflows
   */
  public void findWorkflows(String base) {
    File[] files = new File(base).listFiles();

    for (File f : files) {
      if (f.isDirectory()) {
        findWorkflows(f.getAbsolutePath());
      } else {
        if (f.getName().endsWith("workflow.xml")) {
          workflows.add(f.getAbsolutePath());
        }
      }
    }
  }

  public void testValid() throws Exception {
    workflows.clear();
    findWorkflows(WF_BASE_DIR);

    for (String workflow : workflows) {
      LOG.info("Validating workflow: " + workflow);
      String[] args = new String[] { "validate", workflow };
      assertEquals(0, new OozieCLI().run(args));
    }
  }

}
