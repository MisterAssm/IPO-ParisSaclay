package map;

// Client pour la table de hachage
class MostFrequent {
    public static void main(String[] args) {
        Hashtable t = new Hashtable();
        String[] args1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut volutpat accumsan lorem et laoreet. Praesent mattis nisl at turpis pulvinar congue. Nam ut sagittis ex. Sed imperdiet malesuada mauris, eu ultrices ex. Nam gravida scelerisque lobortis. Suspendisse at sapien sed ante bibendum convallis nec eu est. Ut eu pellentesque sapien, ut sodales tortor. Nunc feugiat ex dui, id bibendum mi viverra ut. In nulla ex, sodales in luctus eu, commodo in mi. Suspendisse a enim at nibh feugiat efficitur eget quis nibh. Etiam at dignissim lacus, vitae sollicitudin massa. Sed purus quam, tempus vestibulum ligula in, pharetra suscipit arcu. Aliquam tincidunt lorem quis neque tristique aliquam. In luctus mi et mauris varius mattis. Suspendisse tortor mauris, rhoncus vitae quam euismod, sagittis lacinia lorem. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.".split(" ");

        for (String s : args1) {
            if (t.contains(s)) {
                t.put(s, (int) t.get(s) + 1);
            } else {
                t.put(s, 1);
            }
        }

        t.remove("at");

        String sMax = "";
        int cMax = 0;

        for (String s : args1) {
            if (t.contains(s)) {
                Integer c = (Integer) t.get(s);

                if (c > cMax) {
                    cMax = c;
                    sMax = s;
                }
            }
        }

        System.out.println("most frequent '" + sMax + "' with " + cMax + " occurrences");
    }
}