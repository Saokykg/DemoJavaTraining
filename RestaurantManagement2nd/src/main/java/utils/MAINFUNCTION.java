package utils;

public enum MAINFUNCTION {
    EXIT,
    ORDER, // khach hang
    BILL, MENU; // manager

    public static MAINFUNCTION fromInt(int x){
        switch (x){
            case 1: return ORDER;
            case 2: return ORDER;
            case 3: return ORDER;
            case 0: return ORDER;
            default:{
                System.out.println("NOT FOUND!!!");
                return null;
            }
        }
    }
}
