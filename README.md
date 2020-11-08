# droolsKafkaSample
This is a sample project using kafka and drools

for installation you must installing kafka and creating two topics with these names "quickstart-events" and "payment-result"
then you can build project with mvn package and run it.

You can call rest service on the address : ${your server address}/sendMessage with POST method and inputs: cardNo, amount, monthlyAmount
the application will be validate this data againts drools rule and put the result on "payment-result" topic on kafka
