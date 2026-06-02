class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        TreeMap<Integer, Integer> landTm = new TreeMap<>();
        TreeMap<Integer, Integer> waterTm = new TreeMap<>();
        int land = getStart(landTm, landStartTime, landDuration);
        int water = getStart(waterTm, waterStartTime, waterDuration);
        
        return Math.min(getEnd(waterTm, land), getEnd(landTm, water));
    }
    
    
    int getStart(TreeMap<Integer, Integer> tm, int[] starts, int[] durations) {
        int time = Integer.MAX_VALUE;
        
        for (int i = 0; i < starts.length; i++) {
            int start = starts[i];
            int duration = durations[i];
            int end = start + duration;
            time = Math.min(time, start + duration);
            var e = tm.floorEntry(start);
            
            if (e != null && e.getValue() <= duration) {
                continue;
            }
            
            while (e != null && end <= e.getKey() + e.getValue()) {
                tm.remove(e.getKey());
                e = tm.lowerEntry(start);
            }
            
            e = tm.higherEntry(start);
            
            while (e != null && e.getValue() >= duration) {
                tm.remove(e.getKey());
                e = tm.higherEntry(start);
            }
            
            if (e == null || end < e.getKey() + e.getValue()) {
                tm.put(start, duration);
            }
        }
        
        return time;
    }
    
    
    int getEnd(TreeMap<Integer, Integer> tm, int start) {
        var e1 = tm.floorEntry(start);
        var e2 = tm.ceilingEntry(start);
        
        if (e1 == null) {
            return e2.getKey() + e2.getValue();
        } else if (e2 == null) {
            return start + e1.getValue();
        }
        
        return Math.min(start + e1.getValue(), e2.getKey() + e2.getValue());
    }
}
