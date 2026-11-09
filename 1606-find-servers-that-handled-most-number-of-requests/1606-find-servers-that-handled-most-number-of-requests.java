
import java.util.*;

class Solution {

    static class Server {
        int serverId;
        int freeTime;

        Server(int serverId, int freeTime) {
            this.serverId = serverId;
            this.freeTime = freeTime;
        }
    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        // Stores IDs of available servers
        TreeSet<Integer> availableServers = new TreeSet<>();

        for (int serverId = 0; serverId < k; serverId++) {
            availableServers.add(serverId);
        }

        // Stores busy servers, ordered by their free time
        PriorityQueue<Server> busyServers =
            new PriorityQueue<>(
                (first, second) ->
                    Integer.compare(first.freeTime, second.freeTime)
            );

        // Counts requests handled by each server
        int[] requestCount = new int[k];

        for (int requestIndex = 0; requestIndex < arrival.length; requestIndex++) {

            // Step 1: Make completed servers available again
            while (!busyServers.isEmpty() &&
                   busyServers.peek().freeTime <= arrival[requestIndex]) {

                Server completedServer = busyServers.poll();

                availableServers.add(completedServer.serverId);
            }

            // Step 2: Find the preferred server
            int preferredServer = requestIndex % k;

            // Step 3: Find the next available server
            Integer selectedServer =
                availableServers.ceiling(preferredServer);

            // If no server exists after preferredServer, wrap around
            if (selectedServer == null && !availableServers.isEmpty()) {
                selectedServer = availableServers.first();
            }

            // If all servers are busy, drop this request
            if (selectedServer == null) {
                continue;
            }

            // Step 4: Assign the request
            availableServers.remove(selectedServer);

            requestCount[selectedServer]++;

            int serverFreeTime =
                arrival[requestIndex] + load[requestIndex];

            busyServers.add(
                new Server(selectedServer, serverFreeTime)
            );
        }

        // Step 5: Find the maximum number of requests
        int maximumRequests = 0;

        for (int count : requestCount) {
            maximumRequests = Math.max(maximumRequests, count);
        }

        // Step 6: Collect all servers with maximum requests
        List<Integer> result = new ArrayList<>();

        for (int serverId = 0; serverId < k; serverId++) {
            if (requestCount[serverId] == maximumRequests) {
                result.add(serverId);
            }
        }

        return result;
    }
}
