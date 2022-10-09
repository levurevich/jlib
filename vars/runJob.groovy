#!groove

def call(String path) {
    try {
        def outSideJob = build job: path
        println 'last 5000 lines of build'
        def subLog = outSideJob.getRawBuild().getLog(5000)
        def stringLog = subLog.join("\n")
        println stringLog
    } catch(e) {
        println 'last 5000 lines of failed build'
        def subLog = e.getCauses()[0].getDownstreamBuild().getLog(5000)
    }
    def stringLog = subLog.join("\n")
    println stringLog
    error('Error due to downstream job failure')
}
