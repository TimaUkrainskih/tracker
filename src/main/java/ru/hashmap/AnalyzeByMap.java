package ru.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double avgScore = 0;
        int total = 0;
        for (Pupil pupil : pupils) {
            total += pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                avgScore += subject.score();
            }
        }
        return total > 0 ? avgScore / total : 0;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double avgScore = 0;
            for (Subject subject : pupil.subjects()) {
                avgScore += subject.score();
            }
            result.add(new Label(pupil.name(), avgScore / pupil.subjects().size()));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Double> subjectTotalScore = new HashMap<>();
        Map<String, Integer> subjectCount = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String subjectName = subject.name();
                double score = subject.score();
                subjectTotalScore.put(subjectName, subjectTotalScore.getOrDefault(subjectName, 0D) + score);
                subjectCount.put(subjectName, subjectCount.getOrDefault(subjectName, 0) + 1);
            }
        }
        List<Label> result = new ArrayList<>();
        for (String nameSubject : subjectTotalScore.keySet()) {
            double total = subjectTotalScore.get(nameSubject);
            int count = subjectCount.get(nameSubject);
            result.add(new Label(nameSubject, total / count));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double total = 0;
            for (Subject subject : pupil.subjects()) {
                total += subject.score();
            }
            Label current = new Label(pupil.name(), total);
            result.add(current);
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Double> subjectTotalScore = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String subjectName = subject.name();
                double score = subject.score();
                subjectTotalScore.put(subjectName, subjectTotalScore.getOrDefault(subjectName, 0D) + score);
            }
        }
        Label best = null;
        for (String nameSubject : subjectTotalScore.keySet()) {
            Label current = new Label(nameSubject, subjectTotalScore.get(nameSubject));
            if (best == null || best.score() < current.score()) {
                best = current;
            }
        }
        return best;
    }
}