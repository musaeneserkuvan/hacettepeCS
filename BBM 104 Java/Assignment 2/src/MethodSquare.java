import java.util.ArrayList;
import java.util.Objects;


public class MethodSquare {

    private static final ArrayList<String> OutputList= new ArrayList<>();

    private static String Args1;
    private static String Args2;
    private static String Args3;


    public void Function(
            Player player1,
            Player player2,
            Player banker,
            Map[] maplist,
            Chance chance,
            CommunityChest chest,
            Land land,
            Company company,
            RailRoads railroad,
            TaxSquares taxsquare,
            Banker banking,
            Reader reader,
            Writer writer,
            MethodSquare funcobj) {

        for (int i = 0; i < reader.getCommandList().size(); i++) {
            String[] CommandLineArgs = reader.getCommandList().get(i).split(";");

            player1.setTempMoney(0);
            player2.setTempMoney(0);
            banker.setTempMoney(0);

            if (Objects.equals(CommandLineArgs[0], "show()")) {
                banking.setWinnerName(player1, player2);

                OutputList.add("-----------------------------------------------------------------------------------------------------------");
                OutputList.add(player1.getPlayerName() + "\t" + player1.getMoney() + "\t" + "have: " + String.join(",", player1.getOwnedPropertyList()));
                OutputList.add(player2.getPlayerName() + "\t" + player2.getMoney() + "\t" + "have: " + String.join(",", player2.getOwnedPropertyList()));
                OutputList.add(banker.getPlayerName() + "\t" + banker.getMoney());

                if (player1.getMoney() > player2.getMoney() || player1.getMoney() < player2.getMoney()) {
                    OutputList.add(banking.getWinnerName());
                } else {
                    OutputList.add("Draw - there is no winner");
                }

                OutputList.add("-----------------------------------------------------------------------------------------------------------");

            } else {

                Player ActivePlayer = null;
                Player InactivePlayer = null;

                if (Objects.equals(CommandLineArgs[0], "Player 1")) {
                    ActivePlayer = player1;
                    InactivePlayer = player2;
                } else if (Objects.equals(CommandLineArgs[0], "Player 2")) {
                    ActivePlayer = player2;
                    InactivePlayer = player1;
                }

                assert ActivePlayer != null;

                if (player1.getMoney() >= 0 && player2.getMoney() >= 0) {

                    ActivePlayer.setDiceNumber(Integer.parseInt(CommandLineArgs[1]));

                    if (ActivePlayer.getJailTimer() == 0) {

                        ActivePlayer.GoMoney(Integer.parseInt(CommandLineArgs[1]) + ActivePlayer.getLocation(), ActivePlayer, banker);
                        ActivePlayer.setLocation(Integer.parseInt(CommandLineArgs[1]) + ActivePlayer.getLocation());


                        if (Objects.equals(maplist[ActivePlayer.getLocation()].getSuperType(), "Property")) {

                            if (ActivePlayer.getOwnedPropertyList().contains(maplist[ActivePlayer.getLocation()].getName())) {

                                if (Objects.equals(ActivePlayer.getTempBuyName(), maplist[ActivePlayer.getLocation()].getName())) {
                                    Args2 = ActivePlayer.getPlayerName() + " bought " + maplist[ActivePlayer.getLocation()].getName();
                                    Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                                    Args3 = null;
                                } else {
                                    Args3 = null;
                                    Args2 = ActivePlayer.getPlayerName() + " has " + maplist[ActivePlayer.getLocation()].getName();
                                    Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                                }
                            } else if (InactivePlayer.getOwnedPropertyList().contains(maplist[ActivePlayer.getLocation()].getName())) {
                                if (Objects.equals(maplist[ActivePlayer.getLocation()].getType(), "Land")) {
                                    Args3 = null;
                                    land.rent(ActivePlayer, InactivePlayer, maplist, CommandLineArgs[1]);
                                    Args2 = ActivePlayer.getPlayerName() + " paid rent for " + maplist[ActivePlayer.getLocation()].getName();
                                    Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                                } else if (Objects.equals(maplist[ActivePlayer.getLocation()].getType(), "Company")) {
                                    Args3 = null;
                                    company.rent(ActivePlayer, InactivePlayer, maplist, CommandLineArgs[1]);
                                    Args2 = ActivePlayer.getPlayerName() + " paid rent for " + maplist[ActivePlayer.getLocation()].getName();
                                    Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                                } else if (Objects.equals(maplist[ActivePlayer.getLocation()].getType(), "RailRoad")) {
                                    Args3 = null;
                                    railroad.rent(ActivePlayer, InactivePlayer, maplist, CommandLineArgs[1]);
                                    Args2 = ActivePlayer.getPlayerName() + " paid rent for " + maplist[ActivePlayer.getLocation()].getName();
                                    Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                                }
                            } else {
                                Args3 = null;
                                banking.TakeAction(ActivePlayer, InactivePlayer, banker, maplist, chance, chest, land, company, railroad, banking);
                                Args2 = ActivePlayer.getPlayerName() + " bought " + maplist[ActivePlayer.getLocation()].getName();

                                Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                            }
                        } else {

                            if (Objects.equals(maplist[ActivePlayer.getLocation()].getName(), "Chance")) {

                                chance.TakeAction(ActivePlayer, InactivePlayer, banker, maplist, chance, chest, land, company, railroad, banking);


                                if (chance.getCardOrder() == 0) {

                                    Args2 = null;
                                    Args3 = ActivePlayer.getPlayerName() + " draw Advance to Go (Collect $200)";
                                    Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                                    chance.setCardOrder((chance.getCardOrder() + 1) % 6);
                                } else if (chance.getCardOrder() == 1) {

                                    if (ActivePlayer.getOwnedPropertyList().contains(maplist[ActivePlayer.getLocation()].getName())) {
                                        Args2 = ActivePlayer.getPlayerName() + " has " + maplist[ActivePlayer.getLocation()].getName();
                                    } else if (InactivePlayer.getOwnedPropertyList().contains(maplist[ActivePlayer.getLocation()].getName())) {

                                        land.rent(ActivePlayer, InactivePlayer, maplist, CommandLineArgs[1]);
                                        Args2 = ActivePlayer.getPlayerName() + " paid rent for " + maplist[ActivePlayer.getLocation()].getName();
                                    } else {
                                        banking.TakeAction(ActivePlayer, InactivePlayer, banker, maplist, chance, chest, land, company, railroad, banking);
                                        Args2 = ActivePlayer.getPlayerName() + " bought " + maplist[ActivePlayer.getLocation()].getName();
                                    }

                                    Args3 = ActivePlayer.getPlayerName() + " draw Advance to Leicester Square ";
                                    Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                                    chance.setCardOrder((chance.getCardOrder() + 1) % 6);

                                } else if (chance.getCardOrder() == 2) {

                                    if (Objects.equals(maplist[ActivePlayer.getLocation()].getSuperType(), "Property")) {
                                        if (ActivePlayer.getOwnedPropertyList().contains(maplist[ActivePlayer.getLocation()].getName())) {
                                            Args2 = ActivePlayer.getPlayerName() + " has " + maplist[ActivePlayer.getLocation()].getName();
                                        } else if (InactivePlayer.getOwnedPropertyList().contains(maplist[ActivePlayer.getLocation()].getName())) {

                                            land.rent(ActivePlayer, InactivePlayer, maplist, CommandLineArgs[1]);
                                            Args2 = ActivePlayer.getPlayerName() + " paid rent for " + maplist[ActivePlayer.getLocation()].getName();
                                        } else {
                                            banking.TakeAction(ActivePlayer, InactivePlayer, banker, maplist, chance, chest, land, company, railroad, banking);
                                            Args2 = ActivePlayer.getPlayerName() + " bought " + maplist[ActivePlayer.getLocation()].getName();
                                        }
                                    } else if (Objects.equals(maplist[ActivePlayer.getLocation()].getType(), "TaxSquare")) {
                                        taxsquare.TakeAction(ActivePlayer, InactivePlayer, banker, maplist, chance, chest, land, company, railroad, banking);
                                        Args2 = ActivePlayer.getPlayerName() + " paid Tax";

                                    } else if (Objects.equals(maplist[ActivePlayer.getLocation()].getName(), "Community Chest")) {
                                        chest.TakeAction(ActivePlayer, InactivePlayer, banker, maplist, chance, chest, land, company, railroad, banking);
                                        if (chest.getCardOrder() == 0) {
                                            Args2 = ActivePlayer.getPlayerName() + " draw Community Chest - Advance to Go (Collect $200)";
                                            chest.setCardOrder((chest.getCardOrder() + 1) % 11);
                                        } else if (chest.getCardOrder() == 1) {

                                            Args2 = ActivePlayer.getPlayerName() + " draw Community Chest - Bank error in your favor - collect $75";
                                            chest.setCardOrder((chest.getCardOrder() + 1) % 11);
                                        } else if (chest.getCardOrder() == 2) {

                                            Args2 = ActivePlayer.getPlayerName() + " draw Community Chest - Doctor's fees - Pay $50";
                                            chest.setCardOrder((chest.getCardOrder() + 1) % 11);
                                        } else if (chest.getCardOrder() == 3) {

                                            Args2 = ActivePlayer.getPlayerName() + " draw Community Chest - It is your birthday Collect $10 from each player ";
                                            chest.setCardOrder((chest.getCardOrder() + 1) % 11);
                                        } else if (chest.getCardOrder() == 4) {

                                            Args2 = ActivePlayer.getPlayerName() + " draw Community Chest - Grand Opera Night - collect $50 from every player for opening night seats";
                                            chest.setCardOrder((chest.getCardOrder() + 1) % 11);
                                        } else if (chest.getCardOrder() == 5) {

                                            Args2 = ActivePlayer.getPlayerName() + " draw Community Chest - Income Tax refund - collect $20";
                                            chest.setCardOrder((chest.getCardOrder() + 1) % 11);
                                        } else if (chest.getCardOrder() == 6) {

                                            Args2 = ActivePlayer.getPlayerName() + " draw Community Chest - Life Insurance Matures - collect $100";
                                            chest.setCardOrder((chest.getCardOrder() + 1) % 11);
                                        } else if (chest.getCardOrder() == 7) {

                                            Args2 = ActivePlayer.getPlayerName() + " draw Community Chest - Pay Hospital Fees of $100";
                                            chest.setCardOrder((chest.getCardOrder() + 1) % 11);
                                        } else if (chest.getCardOrder() == 8) {

                                            Args2 = ActivePlayer.getPlayerName() + " draw Community Chest - Pay School Fees of $50";
                                            chest.setCardOrder((chest.getCardOrder() + 1) % 11);
                                        } else if (chest.getCardOrder() == 9) {

                                            Args2 = ActivePlayer.getPlayerName() + " draw Community Chest - You inherit $100";
                                            chest.setCardOrder((chest.getCardOrder() + 1) % 11);
                                        } else if (chest.getCardOrder() == 10) {

                                            Args2 = ActivePlayer.getPlayerName() + " draw Community Chest - From sale of stock you get $50";
                                            chest.setCardOrder((chest.getCardOrder() + 1) % 11);
                                        }
                                    }

                                    Args3 = ActivePlayer.getPlayerName() + " draw Go back 3 spaces ";
                                    Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                                    chance.setCardOrder((chance.getCardOrder() + 1) % 6);
                                } else if (chance.getCardOrder() == 3) {
                                    Args2 = null;
                                    Args3 = ActivePlayer.getPlayerName() + " draw Pay poor tax of $15 ";
                                    Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                                    chance.setCardOrder((chance.getCardOrder() + 1) % 6);
                                } else if (chance.getCardOrder() == 4) {
                                    Args2 = null;
                                    Args3 = ActivePlayer.getPlayerName() + " draw Your building loan matures - collect $150 ";
                                    Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                                    chance.setCardOrder((chance.getCardOrder() + 1) % 6);
                                } else if (chance.getCardOrder() == 5) {
                                    Args2 = null;
                                    Args3 = ActivePlayer.getPlayerName() + " draw You have won a crossword competition - collect $100 ";
                                    Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                                    chance.setCardOrder((chance.getCardOrder() + 1) % 6);
                                }

                            } else {
                                if (Objects.equals(maplist[ActivePlayer.getLocation()].getName(), "Community Chest")) {
                                    chest.TakeAction(ActivePlayer, InactivePlayer, banker, maplist, chance, chest, land, company, railroad, banking);

                                    if (chest.getCardOrder() == 0) {
                                        Args2 = null;
                                        Args3 = ActivePlayer.getPlayerName() + " draw Community Chest - Advance to Go (Collect $200)";
                                        Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                                        chest.setCardOrder((chest.getCardOrder() + 1) % 11);

                                    } else if (chest.getCardOrder() == 1) {
                                        Args2 = null;
                                        Args3 = ActivePlayer.getPlayerName() + " draw Community Chest - Bank error in your favor - collect $75";
                                        Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                                        chest.setCardOrder((chest.getCardOrder() + 1) % 11);
                                    } else if (chest.getCardOrder() == 2) {
                                        Args2 = null;
                                        Args3 = ActivePlayer.getPlayerName() + " draw Community Chest - Doctor's fees - Pay $50";
                                        Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                                        chest.setCardOrder((chest.getCardOrder() + 1) % 11);
                                    } else if (chest.getCardOrder() == 3) {
                                        Args2 = null;
                                        Args3 = ActivePlayer.getPlayerName() + " draw Community Chest - It is your birthday Collect $10 from each player ";
                                        Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                                        chest.setCardOrder((chest.getCardOrder() + 1) % 11);
                                    } else if (chest.getCardOrder() == 4) {
                                        Args2 = null;
                                        Args3 = ActivePlayer.getPlayerName() + " draw Community Chest - Grand Opera Night - collect $50 from every player for opening night seats";
                                        Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                                        chest.setCardOrder((chest.getCardOrder() + 1) % 11);
                                    } else if (chest.getCardOrder() == 5) {
                                        Args2 = null;
                                        Args3 = ActivePlayer.getPlayerName() + " draw Community Chest - Income Tax refund - collect $20";
                                        Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                                        chest.setCardOrder((chest.getCardOrder() + 1) % 11);
                                    } else if (chest.getCardOrder() == 6) {
                                        Args2 = null;
                                        Args3 = ActivePlayer.getPlayerName() + " draw Community Chest - Life Insurance Matures - collect $100";
                                        Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                                        chest.setCardOrder((chest.getCardOrder() + 1) % 11);
                                    } else if (chest.getCardOrder() == 7) {
                                        Args2 = null;
                                        Args3 = ActivePlayer.getPlayerName() + " draw Community Chest - Pay Hospital Fees of $100";
                                        Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                                        chest.setCardOrder((chest.getCardOrder() + 1) % 11);
                                    } else if (chest.getCardOrder() == 8) {
                                        Args2 = null;
                                        Args3 = ActivePlayer.getPlayerName() + " draw Community Chest - Pay School Fees of $50";
                                        Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                                        chest.setCardOrder((chest.getCardOrder() + 1) % 11);
                                    } else if (chest.getCardOrder() == 9) {
                                        Args2 = null;
                                        Args3 = ActivePlayer.getPlayerName() + " draw Community Chest - You inherit $100";
                                        Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                                        chest.setCardOrder((chest.getCardOrder() + 1) % 11);
                                    } else if (chest.getCardOrder() == 10) {
                                        Args2 = null;
                                        Args3 = ActivePlayer.getPlayerName() + " draw Community Chest - From sale of stock you get $50";
                                        Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                                        chest.setCardOrder((chest.getCardOrder() + 1) % 11);
                                    }
                                } else {
                                    if (Objects.equals(maplist[ActivePlayer.getLocation()].getType(), "TaxSquare")) {
                                        taxsquare.TakeAction(ActivePlayer, InactivePlayer, banker, maplist, chance, chest, land, company, railroad, banking);
                                        Args2 = null;
                                        Args3 = ActivePlayer.getPlayerName() + " paid Tax";
                                        Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";

                                    }
                                    else {
                                        if (Objects.equals(maplist[ActivePlayer.getLocation()].getType(), "BasicSquare")) {

                                            if (Objects.equals(maplist[ActivePlayer.getLocation()].getName(), "Jail")) {
                                                Args2 = null;
                                                Args3 = ActivePlayer.getPlayerName() + " went to jail";
                                                Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                                                ActivePlayer.setJailTimer(1,ActivePlayer);
                                            }

                                            else if (ActivePlayer.getLocation() == 21) {

                                                Args2 = null;
                                                Args3 = ActivePlayer.getPlayerName() + " is in Free Parking";
                                                Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                                                ActivePlayer.setJailTimer(1,ActivePlayer);

                                            }
                                            else if(ActivePlayer.getLocation()==31){
                                                ActivePlayer.setLocation(11);
                                                Args2 = null;
                                                Args3 = ActivePlayer.getPlayerName() + " went to jail";
                                                Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";

                                                ActivePlayer.setJailTimer(1,ActivePlayer);

                                            }
                                            else {
                                                if (Objects.equals(maplist[ActivePlayer.getLocation()].getSuperType(), "GO Square")) {
                                                    Args2 = null;
                                                    Args3 = ActivePlayer.getPlayerName() + " is in GO square";
                                                    Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                                                }
                                            }
                                        }



                                    }

                                }
                            }
                        }


                    }
                    else {

                        if (ActivePlayer.getLocation() == 11) {
                            Args2 = null;
                            Args3 = ActivePlayer.getPlayerName() + " in jail (count=" + ActivePlayer.getJailTimer() + ")";
                            Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";
                            ActivePlayer.setJailTimer(1, ActivePlayer);
                        } else if (ActivePlayer.getLocation() == 21) {
                            Args2 = null;
                            Args3 = ActivePlayer.getPlayerName() + "is in Free Parking";
                            Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";

                            ActivePlayer.setJailTimer(1, ActivePlayer);
                        }
                    }

                    if (player1.getMoney() >= 0 && player2.getMoney() >= 0) {
                        if (Args2 == null) {
                            OutputList.add(Args1 + Args3);
                        } else if (Args3 == null) {
                            OutputList.add(Args1 + Args2);
                        } else {
                            OutputList.add(Args1 + Args3 + Args2);
                        }

                        if (i == reader.getCommandList().size() - 1) {
                            banking.setWinnerName(player1, player2);
                            OutputList.add("-----------------------------------------------------------------------------------------------------------");
                            OutputList.add(player1.getPlayerName() + "\t" + player1.getMoney() + "\t" + "have: " + String.join(",", player1.getOwnedPropertyList()));
                            OutputList.add(player2.getPlayerName() + "\t" + player2.getMoney() + "\t" + "have: " + String.join(",", player2.getOwnedPropertyList()));
                            OutputList.add(banker.getPlayerName() + "\t" + banker.getMoney());

                            if (player1.getMoney() > player2.getMoney() || player1.getMoney() < player2.getMoney()) {
                                OutputList.add(banking.getWinnerName());
                            } else {
                                OutputList.add("Draw - there is no winner");
                            }
                            OutputList.add("-----------------------------------------------------------------------------------------------------------");

                            writer.WriteTxt(funcobj);
                        }
                    } else if (player1.getMoney() < 0) {

                        player1.setMoney(-player1.getTempMoney());
                        player2.setMoney(-player2.getTempMoney());
                        banker.setMoney( -banker.getTempMoney());

                        Args2 = null;
                        Args3 = player1.getPlayerName() + " goes bankrupt";
                        Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";

                        OutputList.add(Args1 + Args3);
                        banking.setWinnerName(player1, player2);

                        OutputList.add("-----------------------------------------------------------------------------------------------------------");
                        OutputList.add(player1.getPlayerName() + "\t" + player1.getMoney() + "\t" + "have: " + String.join(",", player1.getOwnedPropertyList()));
                        OutputList.add(player2.getPlayerName() + "\t" + player2.getMoney() + "\t" + "have: " + String.join(",", player2.getOwnedPropertyList()));
                        OutputList.add(banker.getPlayerName() + "\t" + banker.getMoney());

                        if (player1.getMoney() > player2.getMoney() || player1.getMoney() < player2.getMoney()) {
                            OutputList.add(banking.getWinnerName());
                        } else {
                            OutputList.add("Draw - there is no winner");
                        }

                        OutputList.add("-----------------------------------------------------------------------------------------------------------");

                        writer.WriteTxt(funcobj);
                        break;

                    } else if (player2.getMoney() < 0) {

                        player1.setMoney(-player1.getTempMoney());
                        player2.setMoney(-player2.getTempMoney());
                        banker.setMoney( -banker.getTempMoney());

                        Args2 = null;
                        Args3 = player2.getPlayerName() + " goes bankrupt";
                        Args1 = ActivePlayer.getPlayerName() + "\t" + ActivePlayer.getDiceNumber() + "\t" + ActivePlayer.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t";

                        OutputList.add(Args1 + Args3);
                        banking.setWinnerName(player1, player2);

                        OutputList.add("-----------------------------------------------------------------------------------------------------------");
                        OutputList.add(player1.getPlayerName() + "\t" + player1.getMoney() + "\t" + "have: " + String.join(",", player1.getOwnedPropertyList()));
                        OutputList.add(player2.getPlayerName() + "\t" + player2.getMoney() + "\t" + "have: " + String.join(",", player2.getOwnedPropertyList()));
                        OutputList.add(banker.getPlayerName() + "\t" + banker.getMoney());

                        if (player1.getMoney() > player2.getMoney() || player1.getMoney() < player2.getMoney()) {
                            OutputList.add(banking.getWinnerName());
                        } else {
                            OutputList.add("Draw - there is no winner");
                        }

                        OutputList.add("-----------------------------------------------------------------------------------------------------------");

                        writer.WriteTxt(funcobj);
                        break;

                    }
                }
            }
        }
    }

    public ArrayList<String> getOutputList() {
        return OutputList;
    }


}




