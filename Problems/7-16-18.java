class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) return null;
        if (intervals.size() < 1) return intervals;
        
        // Sort via lambda comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        
        List<Interval> mergedIntervals = new ArrayList<Interval>();
        Interval prevInterval = new Interval(intervals.get(0).start, intervals.get(0).end);
        for (Interval interval : intervals) {
            if (prevInterval.end < interval.start || prevInterval.start > interval.end) {
                mergedIntervals.add(prevInterval);
                prevInterval = interval;
            } else {
                if (prevInterval.start <= interval.end) {
                    prevInterval.start = Math.min(prevInterval.start, interval.start);
                }
                if (prevInterval.end >= interval.start) {
                    prevInterval.end = Math.max(prevInterval.end, interval.end);
                }
            }
        }
        mergedIntervals.add(prevInterval);
        return mergedIntervals;
    }
}
// Note: This is significantly slower than a solution using a proper comparator:
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) return null;
        if (intervals.size() < 1) return intervals;
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2) {
                if (i1.start > i2.start) {
                    return 1;
                } else if (i1.start < i2.start) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        List<Interval> mergedIntervals = new ArrayList<Interval>();
        Interval prevInterval = new Interval(intervals.get(0).start, intervals.get(0).end);
        for (Interval interval : intervals) {
            if (prevInterval.end < interval.start || prevInterval.start > interval.end) {
                mergedIntervals.add(prevInterval);
                prevInterval = interval;
            } else {
                if (prevInterval.start <= interval.end) {
                    prevInterval.start = Math.min(prevInterval.start, interval.start);
                }
                if (prevInterval.end >= interval.start) {
                    prevInterval.end = Math.max(prevInterval.end, interval.end);
                }
            }
        }
        mergedIntervals.add(prevInterval);
        return mergedIntervals;
    }
}
