import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GrammarExercise {

    public static void main(String[] args) throws IOException {
        //需要从命令行读入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstWordList = br.readLine();
        String secondWordList = br.readLine();


/*        String firstWordList = "apple,juice,mother,people,beautiful,apple,dog";
        String secondWordList = "cat,baby,smile,good,apple,beautiful,dog,nice";*/

        List<String> result = findCommonWordsWithSpace(firstWordList, secondWordList);
        //按要求输出到命令行
        System.out.println(Arrays.toString(result.toArray()));


    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码

        if(!isAlphabetic(firstWordList)||!isAlphabetic(secondWordList)) {
            throw new RuntimeException("input not");
        };
        List<String> firstList = java.util.Arrays.asList(firstWordList.toUpperCase().replaceAll("([A-Za-z])([A-Za-z])", "$1 $2 ").split(","));;
        List<String> secondList = java.util.Arrays.asList(secondWordList.toUpperCase().replaceAll("([A-Za-z])([A-Za-z])", "$1 $2 ").split(","));
        List<String> resultList = (List)firstList.stream().filter(s->secondList.contains(s))
                .distinct().collect(Collectors.toList());
        return resultList;
    }


    /**
     * 判读输入字符串中是否含有特殊字符
     * @param s 输入字符串
     * @return true:不含有
     *         false:含有
     */
    private static boolean isAlphabetic(String s) {
        Pattern p = Pattern.compile("^[A-Za-z]*([A-Za-z]+[,])*([A-Za-z]+)$");
        Matcher m = p.matcher(s);
        return m.matches();
    }

/*        List<String> list1 = Arrays.asList(firstWordList.split(","));
        List<String> list2 = Arrays.asList(secondWordList.split(","));
        Long firstCount = list1.stream().filter(string -> string.isEmpty() || (string.chars().filter(s -> s < 'a' || s > 'Z')).count() > 0).count();
        Long secondCount = list2.stream().filter(string -> string.isEmpty() || (string.chars().filter(s -> s < 'a' || s > 'Z')).count() > 0).count();
    //    if (firstCount > 0 || secondCount > 0) throw new RuntimeException("input not");

        System.out.println(firstCount);
        System.out.println(secondCount);
        return null;*/






/*        List<String> list11=list1.stream()
                .map(String::toUpperCase)
                .sorted()
                .distinct()
                .collect(Collectors.toList());;

        List<String> list22=list2.stream()
                .map(String::toUpperCase)
                .sorted()
                .distinct()
                .collect(Collectors.toList());;


        List<String> temp=new ArrayList<>();
        list1.stream().forEach(a -> {
                if(list2.contains(a)){
                    temp.add(a);
                }
                }*/


}