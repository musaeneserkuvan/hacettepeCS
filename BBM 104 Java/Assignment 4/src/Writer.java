import java.io.FileWriter;

public interface Writer {


    default void Write(Datas datas){


        try{
            FileWriter monitor = new FileWriter("assets\\data\\backup.dat");

            for(Users u: datas.getUsersArrayList()){

                String a = "user\t" +
                        u.getUsername() + "\t" +
                        u.getPasswordBase64encoded() + "\t" +
                        u.isMember() + "\t" +
                        u.isAdmin()+"\t";

                monitor.write(a+"\n");
            }

            for (Films f : datas.getFilmsArrayList()){
                String d = "film\t" +
                        f.getFilmName() + "\t" +
                        f.getTrailerpath() + "\t" +
                        f.getFilmduration()+"\t";

                monitor.write(d+"\n");

                for(Halls h : f.getHallslist()){

                    String b = "hall\t"+
                            h.getFilmname()+"\t"+
                            h.getHallname()+"\t"+
                            h.getPriceperseat()+"\t"+
                            h.getRow()+"\t"+
                            h.getCol()+"\t";

                    monitor.write(b+"\n");

                    for (Seats s : h.getSeatslist()){

                        String c = "seat\t"+
                                s.getFilmname()+"\t"+
                                s.getHallname()+"\t"+
                                s.getRow()+"\t"+
                                s.getCol()+"\t"+
                                s.getOwnername()+"\t"+
                                s.getPricesold()+"\t";

                        monitor.write(c+"\n");

                    }


                }


            }


        }
        catch (Exception e){
            e.printStackTrace();
        }



    }
}
