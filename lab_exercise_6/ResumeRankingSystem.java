package lab_exercise_6;


import java.util.*;



class Candidate {

    private final String name;

    private final List<String> skills;

    private final int experience;

    private final boolean hasCertification;

    private final String educationLevel;



    public Candidate(String name, List<String> skills, int experience, boolean hasCertification, String educationLevel) {

        this.name = name;

        this.skills = skills;

        this.experience = experience;

        this.hasCertification = hasCertification;

        this.educationLevel = educationLevel;

    }



    public int calculateScore(List<String> requiredSkills) {

        int skillMatchScore = 0;

        for (String requiredSkill : requiredSkills) {

            if (skills.contains(requiredSkill)) {

                skillMatchScore += 20;

            }

        }



        int experienceScore = experience * 5;

        int certificationScore = hasCertification ? 10 : 0;



        int educationScore;

        if (educationLevel.equalsIgnoreCase("Master’s")) {

            educationScore = 15;

        } else if (educationLevel.equalsIgnoreCase("Bachelor’s")) {

            educationScore = 10;

        } else {

            educationScore = 5;

        }



        return skillMatchScore + experienceScore + certificationScore + educationScore;

    }



    public void displayCandidate(int rank) {

        System.out.printf("#%-2d | %-10s | Skills: %-20s | Exp: %d years | Cert: %b | Edu: %-10s%n",

                rank, name, skills, experience, hasCertification, educationLevel);

    }

}



class JobMatcher {

    public static List<Candidate> matchCandidates(List<Candidate> candidates, List<String> requiredSkills) {

        candidates.sort((c1, c2) -> Integer.compare(c2.calculateScore(requiredSkills), c1.calculateScore(requiredSkills)));

        return candidates;

    }

}



public class ResumeRankingSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Candidate> candidates = new ArrayList<>();



        System.out.print("Enter the number of candidates: ");

        int numCandidates = scanner.nextInt();

        scanner.nextLine();



        for (int i = 1; i <= numCandidates; i++) {

            System.out.println("\nEnter details for Candidate " + i + ":");

            System.out.print("Name: ");

            String name = scanner.nextLine();



            System.out.print("Enter skills (comma-separated): ");

            List<String> skills = Arrays.asList(scanner.nextLine().split(","));



            System.out.print("Years of experience: ");

            int experience = scanner.nextInt();



            System.out.print("Has certification? (true/false): ");

            boolean hasCertification = scanner.nextBoolean();

            scanner.nextLine();



            System.out.print("Education Level (Diploma/Bachelor’s/Master’s): ");

            String educationLevel = scanner.nextLine();



            candidates.add(new Candidate(name, skills, experience, hasCertification, educationLevel));

        }



        System.out.println("\nEnter required job skills (comma-separated): ");

        List<String> requiredSkills = Arrays.asList(scanner.nextLine().split(","));



        System.out.println("\nRanking Candidates...");

        List<Candidate> rankedCandidates = JobMatcher.matchCandidates(candidates, requiredSkills);



        System.out.println("Top Candidates for the Role:");

        System.out.println("---------------------------------------------------");

        int rank = 1;

        for (Candidate candidate : rankedCandidates) {

            candidate.displayCandidate(rank++);

        }

    }

}