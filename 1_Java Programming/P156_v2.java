// 모든 기능이 Team이라는 추상 클래스 하나에 통합됨
abstract class Team {
    String name;

    Team(String name) {
        this.name = name;
    }

    // 1. 공통 기능 (수정 불가)
    public void intro() {
        System.out.println(name + "팀입니다.");
    }

    // 2. 강제 구현 기능 (추상 메서드)
    // 상속받는 모든 팀은 아래 3개 메서드를 "무조건" 오버라이딩해야 함
    public abstract void work();
    public abstract void report();   // 원래 인터페이스에 있던 것
    public abstract void approve();  // 원래 인터페이스에 있던 것
}

// 이제 SupportTeam은 Team만 상속받아도 모든 숙제를 해야 함
class SupportTeam extends Team {
    
    SupportTeam(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println("고객 문의를 해결 중입니다.");
    }

    @Override
    public void report() {
        System.out.println("고객지원팀 보고 완.");
    }

    @Override
    public void approve() {
        System.out.println("고객지원팀 결재 완.");
    }
}

// 만약 새로운 팀을 만든다면?
class CleanTeam extends Team {
    CleanTeam(String name) { super(name); }

    @Override
    public void work() { System.out.println("청소를 합니다."); }

    // [문제 발생] 청소팀은 결재 권한이 없는데도 강제로 구현해야 함
    @Override
    public void report() { System.out.println("할 게 없지만 강제로 적음"); }
    
    @Override
    public void approve() { System.out.println("권한이 없지만 빈 칸으로라도 둠"); }
}