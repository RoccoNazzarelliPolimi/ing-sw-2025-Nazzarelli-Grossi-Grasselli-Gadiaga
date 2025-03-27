public class TileRemovalVisitor implements TileVisitor {
    private PlayerBoard playerBoard;
    private Player player;

    public TileRemovalVisitor(PlayerBoard playerBoard, Player player) {
        this.playerBoard = playerBoard;
        this.player = player;
    }

    @Override
    public void visit(Pipe pipe) {
    }

    @Override
    public void visit(Shield shield) {
        playerBoard.askcol();
    }


    @Override
    public void visit(Drill drill) {
    }

    @Override
    public void visit(HousingUnit housingUnit) {
        if (housingUnit.hasAlien()) {
            playerBoard.decreasePassengersPower(2);
        } else {
            playerBoard.decreasePassengersPower(housingUnit.countPassengers());
        }
    }

    @Override
    public void visit(Heater heater) {
        playerBoard.decreaseHeaterPower(heater.getValue());
    }

    @Override
    public void visit(PowerCenter powerCenter) {
        playerBoard.decreaseBatteries(powerCenter.checkBattery());
    }

    @Override
    public void visit(AlienAddOn alienAddOn) {
    }

    @Override
    public void visit(CentralHousingUnit centralHousingUnit) {
    }

    @Override
    public void visit(Storage storage) {
    }

}