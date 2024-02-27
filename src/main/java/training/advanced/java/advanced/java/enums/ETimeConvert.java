package training.advanced.java.advanced.java.enums;

public enum ETimeConvert {
    DAY(1,
        1,
        24) {
        @Override
        public long convertToMilis(long time) {
            return HOUR.convertToMilis(time * getDownMetric());
        }
    },
    HOUR(2,
         24,
         60) {
        @Override
        public long convertToMilis(long time) {
            return MINUTE.convertToMilis(time * getDownMetric());
        }
    },
    MINUTE(3,
           60,
           60) {
        @Override
        public long convertToMilis(long time) {
            return SECOND.convertToMilis(time * getDownMetric());
        }
    },
    SECOND(4,
           60,
           1_000) {
        @Override
        public long convertToMilis(long time) {
            return MILIS.convertToMilis(time * getDownMetric());
        }

    },
    MILIS(5,
          1_000,
          1);

    private final int  index;
    private final long upMetric;
    private final long downMetric;

    ETimeConvert(final int indexParam,
                 final long upMetricParam,
                 final long downMetricParam) {
        index      = indexParam;
        upMetric   = upMetricParam;
        downMetric = downMetricParam;
    }

    public long convertToMilis(long time) {
        return time;
    }

    public double convertToUnit(long time,
                                ETimeConvert unit) {
        if (unit.getIndex() == index) {
            return time;
        } else if (unit.getIndex() > index) {
            return down(time,
                        unit);
        } else {
            return up(time,
                      unit);
        }
    }

    public double up(final double timeParam,
                      final ETimeConvert unitParam) {
        double tempParam = timeParam;
        if (unitParam.getIndex() == index) {
            return timeParam;
        }
        int ordinalLoc = ordinal();
        ETimeConvert[] valuesLoc = ETimeConvert.values();
        if (ordinalLoc == 0){
            return timeParam;
        }
        ordinalLoc--;
        tempParam /= upMetric;
        return valuesLoc[ordinalLoc].up(tempParam, unitParam);

    }

    public double down(final double timeParam,
                        final ETimeConvert unitParam) {
        double tempParam = timeParam;
        if (unitParam.getIndex() == index) {
            return timeParam;
        }
        int ordinalLoc = ordinal();
        ETimeConvert[] valuesLoc = ETimeConvert.values();
        if (ordinalLoc >=valuesLoc.length -1){
            return timeParam;
        }
        ordinalLoc++;
        tempParam *= downMetric;
        return valuesLoc[ordinalLoc].down(tempParam, unitParam);

    }

    public int getIndex() {
        return index;
    }

    public long getUpMetric() {
        return upMetric;
    }

    public long getDownMetric() {
        return downMetric;
    }
}
