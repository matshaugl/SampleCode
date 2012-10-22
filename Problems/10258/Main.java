import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// final BufferedReader in = new BufferedReader(new FileReader("sampleinput"));
		int t = Integer.parseInt(in.readLine());
		int c = 0;
		String[] tokens;
		String line;
		in.readLine();
		while (c < t) {
			c++;
			List<Submission> submissions = new ArrayList<Submission>();

			while ((line = in.readLine()) != null) {
				if (line.equals("")) {
					break;
				}
				tokens = line.split(" ");
				submissions.add(new Submission(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), tokens[3]));
			}

			// Scoreboard
			Collections.sort(submissions);
			List<Contestant> board = new ArrayList<Contestant>();

			if (!submissions.isEmpty()) {
				Contestant contestant = null;
				for (int i = 0; i < submissions.size(); i++) {
					Submission submission = submissions.get(i);

					if ((contestant == null) || (submission.contestant != contestant.number)) {
						contestant = new Contestant();
						contestant.number = submission.contestant;
						board.add(contestant);
					}

					contestant.addSubmission(submission);
				}
				Collections.sort(board);
			}

			// Output
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < board.size(); i++) {
				sb.append(board.get(i).toString());
				if (i < board.size() - 1) {
					sb.append("\n");
				}
			}
			if (c < t) {
				sb.append("\n");
			}
			System.out.println(sb.toString());
		}
	}

	static class Submission implements Comparable<Submission> {
		int contestant;
		int problem;
		int time;
		String verdict;

		public Submission(int contestant, int problem, int time, String verdict) {
			this.contestant = contestant;
			this.problem = problem;
			this.time = time;
			this.verdict = verdict;
		}

		public boolean isC() {
			return verdict.equals("C");
		}

		public boolean isI() {
			return verdict.equals("I");
		}

		@Override
		public int compareTo(Submission o) {
			if (this.contestant > o.contestant) {
				return 1;
			} else if (this.contestant < o.contestant) {
				return -1;
			} else if (this.problem > o.problem) {
				return 1;
			} else if (this.problem < o.problem) {
				return -1;
			} else if (this.time > o.time) {
				return 1;
			} else if (this.time < o.time) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	static class Contestant implements Comparable<Contestant> {
		int number;
		int penaltyTime;
		int[] problems = new int[9];
		int solved = 0;

		int currentPenalty = 0;
		int previousProblem = -1;

		void addSubmission(Submission submission) {
			if (previousProblem != -1 && submission.problem != previousProblem)
				currentPenalty = 0;

			if (submission.isC()) {
				int index = submission.problem - 1;
				if (problems[index] == 0) {
					problems[index] = 1;
					penaltyTime += currentPenalty + submission.time;
					solved++;
				}
			} else if (submission.isI()) {
				currentPenalty += 20;
			}

			previousProblem = submission.problem;
		}

		public String toString() {
			return number + " " + solved + " " + penaltyTime;
		}

		@Override
		public int compareTo(Contestant o) {
			if (this.solved > o.solved)
				return -1;
			else if (this.solved < o.solved)
				return 1;
			else if (this.penaltyTime > o.penaltyTime)
				return 1;
			else if (this.penaltyTime < o.penaltyTime)
				return -1;
			else if (this.number > o.number)
				return 1;
			else if (this.number < o.number)
				return -1;
			else
				return 0;
		}
	}
}
