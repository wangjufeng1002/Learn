package exam;

import java.util.*;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/6/30
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            if (split.length < 6) {
                System.out.println("ERROR");
            }
            if (check(split)) {
                System.out.println(countHandler(split));
            } else {
                System.out.println("ERROR");
            }

        }
    }

    public static boolean check(String[] inputArr) {
        try {
            for (int i = 0; i < 4; i++) {
                String val = inputArr[i];
                if (val.contains(".")) {
                    return false;
                }
                if (Integer.parseInt(val) <= 0) {
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            return false;
        }
        if (!"HKD".equals(inputArr[4]) &&
                !"CNY".equals(inputArr[4]) &&
                !"USD".equals(inputArr[4]) &&
                !"GBP".equals(inputArr[4])) {
            return false;
        }
        return "MAX".equals(inputArr[5]) || "MIN".equals(inputArr[5]);
    }

    public static String countHandler(String[] inputArr) {
        try {
            int[] values = new int[4];
            String[] valueNames = {"GBP", "USD", "CNY", "HKD"};
            //1GBP
            values[0] = 1;
            values[1] = Integer.parseInt(inputArr[2]);
            values[2] = values[1] * Integer.parseInt(inputArr[1]);
            values[3] = values[2] * Integer.parseInt(inputArr[0]);
            int money = Integer.parseInt(inputArr[3]);
            int baseIndex = 0;
            if ("GBP".equals(inputArr[4])) {
                baseIndex = 0;
            } else if ("USD".equals(inputArr[4])) {
                baseIndex = 1;
            } else if ("CNY".equals(inputArr[4])) {
                baseIndex = 2;
            } else if ("HKD".equals(inputArr[4])) {
                baseIndex = 3;
            }
            Map<String, Integer> map = new HashMap<>(4);
            if ("MAX".equals(inputArr[5])) {
                int baseValue = values[baseIndex];
                int back = 0, baclIndex = -1;
                while (money != 0) {
                    if (baclIndex != -1) {
                        baclIndex--;
                        money += back;
                        map.put(valueNames[baclIndex], map.get(valueNames[baclIndex]) - 1);
                    }
                    for (int i = 0; i < 4; i++) {
                        int x = baseValue / values[i];
                        back = x;
                        int temp = money % (x);
                        if (temp == 0) {
                            if (money / x == 0) {
                                baclIndex = i;
                                continue;
                            }
                            map.put(valueNames[i], money / x);
                            money = temp;
                            break;
                        } else {
                            if (money / x == 0) {
                                baclIndex = i;
                                continue;
                            }
                            map.put(valueNames[i], money / x);
                            money = temp;
                        }
                    }
                }

            } else {
                int back = 0, baclIndex = -1;
                int baseValue = values[baseIndex];
                while (money != 0) {
                    if (baclIndex != -1) {
                        baclIndex++;
                        money += back;
                        map.put(valueNames[baclIndex], map.get(valueNames[baclIndex]) - 1);
                    }
                    for (int i = 3; i >= 0; i--) {
                        int x = baseValue / values[i];
                        int temp = money % x;
                        if (temp == 0) {
                            if (money / x == 0) {
                                baclIndex = i;
                                continue;
                            }
                            map.put(valueNames[i], money / x);
                            break;
                        } else {
                            if (money / x == 0) {
                                baclIndex = i;
                                continue;
                            }
                            map.put(valueNames[i], money / x);
                            money = temp;
                        }
                    }
                }
            }
            String result = "";
            for (String key : valueNames) {
                if (map.get(key) != null) {
                    result += " " + map.get(key) + " " + key;
                }
            }
            return result.substring(1, result.length());

        } catch (NumberFormatException e) {
            return "ERROR";
        }
    }

}
