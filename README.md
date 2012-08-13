Oozie workflow examples
=============

Demonstrates how to develop an Oozie workflow application and aim's to show-case some of Oozie's features.


Build
-------------

Maven is used to build the application bundle and it is assumed Maven is installed and on your path.

To build the application simply run:

	mvn package

The Maven assembly plugin is used to generate a .tar.gz file which contains all of the workflow and configuration files in the required layout:	

	oozie-examples-[VERSION]-bundle.tar.gz

	/workflow.xml
	/config-default.xml
	|
	/conf/ 	(job config)
	/lib/ 	(*.jar;*.so)


Deploy
-------------

	rm -rf examples-oozie
	tar -xvzf oozie-examples-0.0.1-SNAPSHOT-bundle.tar.gz

	hadoop fs -rm -r /workflows/oozie-examples
	hadoop fs -put oozie-examples /workflows/oozie-examples


Run
-------------

	export OOZIE_URL=http://ubuntu:11000/oozie
	oozie job -config oozie-examples/job.properties -run

### Run parallel mapreduce jobs in sub-workflow

	oozie job -config oozie-examples/job.properties -D jump.to=parallel -run

TODO
-------------

Demonstrate custom Java action and the output properties:

When running a custom Java action Oozie sets the "oozie.action.output.properties" property. It's value is a path to a local file on the node that the Java action runs. What you can do is write any number of properties (java.util.Properties) to this file and Oozie can retrieve them afterwards from the workflow by calling ${(wf:actionData('java_action_name')['key']))}