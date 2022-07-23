package done;
public class validUtf8 {
    public static void main(String[] args) {
        validUtf8 v1 = new validUtf8();
        int[] data = { 240,162,138,147};
        System.out.println(v1.validUtf8Function(data));
    }

    public boolean validUtf8Function(int[] data) {
        int n = data.length;
        for (int i = 0; i < n;) {   
            if (data[i] >> 7 == 0){
                    i++;
                    continue;
            }
            else if (data[i] >> 5 == 0b110) {
                //若两字节的数后一字节不为10开头，则返回false
                if ((i++ < n) && data[i] >> 6 != 0b10)
                    return false;
                i += 1;
            }
            else if (data[i] >> 4 == 0b1110) {
                //若后两字节的数不为10 开头 返回false
                if (i + 2 >= n)
                    return false;
                for (int j = 1; j <= 2; j++) {
                    if (data[i + j] >> 6 != 0b10)
                        return false;
                }
                i += 3;
            }
            else if (data[i] >> 3 == 0b11110) {
                // 若后两字节的数不为10 开头 返回false
                if (i + 3 >= n)
                    return false;
                for (int j = 1; j <= 3; j++) {
                    if (data[i + j] >> 6 != 0b10)
                        return false;
                }
                i += 4;
            }
            else {
                return false;}
        }
        return true;
    }
}
