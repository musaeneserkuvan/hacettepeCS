
public class PlayGame{



    Writer writerobject= new Writer();

    MethodSquare METHODSQUAREOBJECT = new MethodSquare();

    /// DEFİNE PLAYERS
    Player PLAYER1OBJECT = new Player("Player 1",15000,1);
    Player PLAYER2OBJECT = new Player("Player 2",15000,1);
    Player PLAYERBANKER= new Player("Banker",100000,0);

    /// DEFİNE BOARD
    Map[] MAPOBJECT = new Map[41];

    /// DEFİNE OBJECTS FUNCTİONS
    Chance CHANCEOBJECT = new Chance();
    CommunityChest CHESTOBJECT = new CommunityChest();
    TaxSquares TAXSQUAREOBJECT=new TaxSquares();
    UtilitySquares UTILITYSQUAREOBJECT = new UtilitySquares();

    Land LANDOBJECT = new Land();
    Company COMPANYOBJECT = new Company();
    RailRoads RAILROADOBJECT= new RailRoads();

    Banker BANKEROBJECT = new Banker();

    PropertyJsonReader MAPOBJECTObj1 = new PropertyJsonReader(MAPOBJECT);
    ListJsonReader SquareObj1 = new ListJsonReader(CHANCEOBJECT,CHESTOBJECT);

    MethodSquare FuncOBJ = new MethodSquare();



    public PlayGame(Reader readerobj){


        /// CHANCEOBJECT SQUARE
        MAPOBJECT[8]= new UtilitySquares(8,0,"Chance","ActionSquare","ActionSquare");
        MAPOBJECT[23]= new UtilitySquares(23,0,"Chance","ActionSquare","ActionSquare");
        MAPOBJECT[37]= new UtilitySquares(37,0,"Chance","ActionSquare","ActionSquare");

        /// CHESTOBJECT SQUARE
        MAPOBJECT[3]= new UtilitySquares(3,0,"Community Chest","ActionSquare","ActionSquare");
        MAPOBJECT[18]= new UtilitySquares(18,0,"Community Chest","ActionSquare","ActionSquare");
        MAPOBJECT[34]= new UtilitySquares(34,0,"Community Chest","ActionSquare","ActionSquare");

        /// TAX SQUARE
        MAPOBJECT[5]= new UtilitySquares(5,0,"IncomeTax","TaxSquare","TaxSquare");
        MAPOBJECT[39]= new UtilitySquares(39,0,"SuperTax","TaxSquare","TaxSquare");

        /// BASIC SQUARE
        MAPOBJECT[1]= new UtilitySquares(1,0,"GO","BasicSquare","GO Square");
        MAPOBJECT[11]= new UtilitySquares(11,0,"Jail","BasicSquare","BasicSquare");
        MAPOBJECT[21]= new UtilitySquares(21,0,"Free Parking","BasicSquare","BasicSquare");
        MAPOBJECT[31]= new UtilitySquares(31,0,"Go to Jail","BasicSquare","BasicSquare");


        METHODSQUAREOBJECT.Function(
                PLAYER1OBJECT,
                PLAYER2OBJECT,
                PLAYERBANKER,
                MAPOBJECT,
                CHANCEOBJECT,
                CHESTOBJECT,
                LANDOBJECT,
                COMPANYOBJECT,
                RAILROADOBJECT,
                TAXSQUAREOBJECT,
                BANKEROBJECT,
                readerobj,
                writerobject,
                FuncOBJ);

    }
}

