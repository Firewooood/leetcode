JAVA
引入输入包 import java.util.Scanner;
类名必须为Main

```java
import java.util.Scanner;
public class Main{
  public static void main(String [] args){
	Scanner in = new Scanner(System.in);
	}
}
```

`System.out.println()`带换行的输出
`System.out.print()`不带换行的输出

`scanner.hasNextInt()`/`scanner.nextInt()`
`scanner.hasNextInt()` **判断输入的这个字符是不是int类型，而不是接受这个字符**
一般和`scanner.nextInt()`结合使用
`scanner.nextInt()`从控制台读取一个int类型,**将空格看作是两个输入的数据的间隔**

```java
Scanner scanner = new Scanner(System.in);
while(scanner.hasNextInt()){//如果输入的这个字符是int类型，那么获取
	int num = scanner.nextInt();
}
```

`scanner.nextLine()`/`scanner.next()`
`scanner.nextLine()`:读取一行，返回String类型
`scanner.hasNextLine()`:根据行匹配模式去判断接下来是否有一行(包括空行\n)
`scanner.next()`:将空格看作是两个字符串的间隔，返回字符串
`scanner.hasnext()`:会判断接下来是否有非空字符