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

	hadoop fs -rmr /workflows/oozie-examples
	hadoop fs -put oozie-examples /workflows/oozie-examples


Run
-------------

	export OOZIE_URL=http://ubuntu:11000/oozie
	oozie job -config oozie-examples/job.properties -run

### Run parallel mapreduce jobs in sub-workflow

	oozie job -config oozie-examples/job.properties -D jump.to=parallel -run
	
### Coordinator

The Oozie Coordinator system allows you to define and execute recurrent and interdependent workflow jobs (data application pipelines). A data application pipeline is a chain of coordinator/workflow jobs that can run at regular intervals, different intervals, or be triggered by some external event (data availability). For example, the output of the last 4 runs of a workflow that runs every 15 minutes become the input of another workflow that runs every 60 minutes.

The coordinator job bundled with this example simply runs the workflow at 5 minute intervals between the given start and end dates. To deploy the coordinator job run the following command:

	oozie job -config oozie-examples/coordinator/coord.properties -D start=$(date -u +"%FT%H:%MZ") -D end=$(date -u -d "+ 1 hour" +"%FT%H:%MZ") -D mode=single -run

To stop the coordinator job run:

	oozie job -kill [coord job id]
	
