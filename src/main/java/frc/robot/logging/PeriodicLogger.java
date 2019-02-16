package frc.robot.logging;



public class PeriodicLogger {

    private LogWrapper mLog;

    private int mPeriod;

    private int mCallCount;


    /**
     * Only log every Nth call to the logger
     * @param logger
     * @param callCount
     */
    public PeriodicLogger(LogWrapper logger, int period) {
        mLog = logger;
        mPeriod = period;
        mCallCount = 0;
    }


    public void info(String msg) {
        if (++mCallCount >= mPeriod) {
            mLog.info(msg);
            mCallCount = 0;
        }
    }

    public void infomf(String msg, Object... params) {
        if (++mCallCount >= mPeriod) {
            mLog.infomf(msg, params);
            mCallCount = 0;
        }
    }

    public void info(String msg, Object... params) {
        if (++mCallCount >= mPeriod) {
            mLog.info(msg, params);
            mCallCount = 0;
        }
    }

    public void debug(String msg) {
        if (++mCallCount >= mPeriod) {
            mLog.debug(msg);
            mCallCount = 0;
        }
    }

    public void debugmf(String msg, Object... params) {
        if (++mCallCount >= mPeriod) {
            mLog.debugmf(msg, params);
            mCallCount = 0;
        }
    }

    public void debug(String msg, Object... params) {
        if (++mCallCount >= mPeriod) {
            mLog.debug(msg, params);
            mCallCount = 0;
        }
    }

}