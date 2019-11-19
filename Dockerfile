FROM payara/server-full
COPY target/Congresso.war $DEPLOY_DIR
