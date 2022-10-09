#!groove

def info(message) {
    echo "INFO: ${message}"
    def outSideJob = build job: message
    echo 'last 5000 lines of build'
}

def warning(message) {
    echo "WARNING: ${message}"
    def outSideJob = build job: message
    echo 'last 5000 lines of build'
    def subLog = outSideJob.getRawBuild().getLog(50)
    def stringLog = subLog.join("\n")
    echo stringLog
}