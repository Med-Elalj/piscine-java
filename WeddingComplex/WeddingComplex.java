import java.util.*;

public class WeddingComplex {

    public static Map<String, String> createBestCouple(Map<String, List<String>> first,
                                                       Map<String, List<String>> second) {

         Map<String, String> engagedTo = new HashMap<>();

         Map<String, String> partnerOfSecond = new HashMap<>();

         Map<String, Map<String, Integer>> secondRankings = new HashMap<>();
        for (var entry : second.entrySet()) {
            String person = entry.getKey();
            List<String> prefs = entry.getValue();

            Map<String, Integer> ranks = new HashMap<>();
            for (int i = 0; i < prefs.size(); i++) {
                ranks.put(prefs.get(i), i);
            }
            secondRankings.put(person, ranks);
        }

         Map<String, Integer> nextProposalIndex = new HashMap<>();
        for (String p : first.keySet()) nextProposalIndex.put(p, 0);

         Queue<String> free = new ArrayDeque<>(first.keySet());

        while (!free.isEmpty()) {
            String proposer = free.poll();
            List<String> proposerPrefs = first.get(proposer);
            int index = nextProposalIndex.get(proposer);

             String desired = proposerPrefs.get(index);
            nextProposalIndex.put(proposer, index + 1);

            String currentPartner = partnerOfSecond.get(desired);

            if (currentPartner == null) {
                 partnerOfSecond.put(desired, proposer);
                engagedTo.put(proposer, desired);

            } else {
                 Map<String, Integer> ranks = secondRankings.get(desired);

                boolean prefersNew =
                        ranks.get(proposer) < ranks.get(currentPartner);

                if (prefersNew) {
                     partnerOfSecond.put(desired, proposer);
                    engagedTo.put(proposer, desired);

                     engagedTo.remove(currentPartner);
                    free.add(currentPartner);

                } else {
                     free.add(proposer);
                }
            }
        }

        return engagedTo;
    }
}
