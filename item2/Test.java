class Test {
    public static void main(String[] args) {
        Dictionary dict = Dictionary.createObjectBuilder().addString("id", "tata").addInteger("inr", 232)
                .addDictionary("Dict",
                        Dictionary.createObjectBuilder().addString("id2", "tata2").addInteger("inr2", 2322)
                        .addDictionary("Dict2",
                        Dictionary.createObjectBuilder().addString("id23", "tata23").addInteger("inr23", 23223).build()).build())
                .build();
        dict.printDictionary();
    }
}
