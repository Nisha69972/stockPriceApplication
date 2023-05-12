pipeline {
	agent any
		stages {
			stage('Clean stage') {
				steps {
					dir("StockPricesApp") {
						bat 'D:\\apache-maven-3.6.3-bin\\apache-maven-3.6.3\\bin\\mvn clean'
					}
				}
			}
			stage('Compile stage') {
				steps {
					dir("StockPricesApp") {
						bat 'D:\\apache-maven-3.6.3-bin\\apache-maven-3.6.3\\bin\\mvn compile'
					}
				}
			}
			stage('Install stage') {
				steps {
					dir("StockPricesApp") {
						bat 'D:\\apache-maven-3.6.3-bin\\apache-maven-3.6.3\\bin\\mvn install'
					}
				}
			}
				stage('Deploy stage') {
			steps {
				dir("StockPricesApp/target") {
					withEnv(['JENKINS_NODE_COOKIE=DontKillMe']) {
						bat 'start java -Dserver.port=3000 -jar TransferFundsApp-0.0.1-SNAPSHOT.jar'
					}
				}
			}
		}
			
		}
}


