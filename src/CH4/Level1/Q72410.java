package CH4.Level1;

/**
 * ==========================================================
 * [제목] 신규 아이디 추천
 * ==========================================================
 * [문제]
 * 규칙에 맞지 앉는 아이디가 입력헀을 때, 입력한 아이디와 유사하고
 * 규칙에 맞는 아이디를 추천
 * 네오는 다음과 같은 순차적인 처리과정을 통해 신규 유저에게 아이디를 추천
 * 1단계 : new_id 의 모든 대문자를 소문자로 치환
 * 2단계 : new_id 에서 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자를 제거
 * 3단계 : new_id 에서 마침표가 2번 이상 연속된 부분을 하나의 마침표로 치환
 * 4단계 : new_id 에서 마침표가 처음이나 끝에 위치하면 제거
 * 5단계 : new_id 가 빈 문자열이라면 "a"를 대입
 * 6단계 : new_id의 길이가 16자 이상이면, new_id 의 첫 15개의 문자를 제외하고 모두 제거,
 * : 만약 제거 후 마침표가 끝에 위치한다면, 마침표 제거
 * 7단계 : new_id 의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙임
 * ==========================================================
 * [제한 사항]
 * 아이디의 길이는 3자이상 15자 이하
 * 아이디는 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표 문자만 사용가능
 * 단, 마침표는 처음과 끝에 사용할 수 없으며, 연속사용 불가
 * ==========================================================
 * [풀이]
 */
public class Q72410 {

    public static void main(String[] args) {
        Q72410 instance = new Q72410();

        String solution1 = instance.solution("=.=");
        String solution2 = instance.solution("z-+.^.");
        String solution3 = instance.solution("abcdefghijklmn.p");
        String solution4 = instance.solution("...!@BaT#*..y.abcdefghijklm");
        String solution5 = instance.solution("123_.def");

        System.out.println("solution = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
        System.out.println("solution4 = " + solution4);
        System.out.println("solution5 = " + solution5);
    }

    public String solution(String new_id) {

        return new KAKAOID(new_id)
                .replaceToLowerCase()
                .filter()
                .toSingleDot()
                .noStartEndDot()
                .noBlack()
                .noGreaterThan16()
                .noLessThan2().getResult();
    }

    private static class KAKAOID {

        private String user_id;

        public KAKAOID(String user_id) {
            this.user_id = user_id;
        }

        // STEP1
        private KAKAOID replaceToLowerCase() {
            user_id = user_id.toLowerCase();
            return this;
        }

        // STEP2
        private KAKAOID filter() {
            user_id = user_id.replaceAll("[^a-z0-9._-]", "");
            return this;
        }

        private KAKAOID toSingleDot() {
            user_id = user_id.replaceAll("\\.+", ".");
            return this;
        }

        private KAKAOID noStartEndDot() {
            user_id = user_id.replaceAll("^[.]|[.]$", "");
            return this;
        }

        private KAKAOID noBlack() {
            user_id = user_id.isEmpty() ? "a" : user_id;
            return this;
        }

        private KAKAOID noGreaterThan16() {
            if (user_id.length() >= 16) {
                user_id = user_id.substring(0, 15);
            }
            user_id = user_id.replaceAll("[.]$", "");
            return this;
        }

        private KAKAOID noLessThan2() {
            StringBuilder sb = new StringBuilder(user_id);
            while (sb.length() < 3) {
                sb.append(sb.charAt(sb.length() - 1));
            }

            user_id = sb.toString();
            return this;
        }

        private String getResult() {
            return user_id;
        }

    }


}
