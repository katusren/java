package chapter12.hashcode;

public class Key {

    public int number;
    public int name;
    public int addr;

    public Key(int number) {
        this.number = number;
    }

    // 물리적 주소
    @Override
    public int hashCode() {
        // return super.hashCode(); // 실제 heap 메모리에 16진수로 된 주소
        return number;
    }

    // 논리적 주소(데이터)
    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Key) {
            Key compareKey = (Key) obj;
            if (this.number == compareKey.number)
                return true;
            else
                return false;
        } else
            return false;
    }

}
