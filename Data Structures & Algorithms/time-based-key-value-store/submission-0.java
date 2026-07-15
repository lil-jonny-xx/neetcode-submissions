class TimeMap {

    private Map<String, List<Entry>> keyStore;

    public TimeMap() {
        keyStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        Entry entry = new Entry(timestamp, value);

        keyStore.computeIfAbsent(key, k -> new ArrayList<>()).add(entry);
    }

    public String get(String key, int timestamp) {

        List<Entry> values = keyStore.getOrDefault(key, new ArrayList<>());

        int left = 0;
        int right = values.size() - 1;

        String result = "";

        while (left <= right) {

            int mid = left + (right - left) / 2;

            Entry entry = values.get(mid);

            if (entry.timestamp <= timestamp) {
                result = entry.value;
                left = mid + 1;      // Try to find a later valid timestamp
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static class Entry {

        int timestamp;
        String value;

        Entry(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}