public class TileRemovalVisitor implements TileVisitor {
    private PlayerBoard playerBoard;
    private Player player;

    public TileRemovalVisitor(PlayerBoard playerBoard, Player player) {
        this.playerBoard = playerBoard;
        this.player = player;
    }

    @Override
    public void visit(Drill drill) {
        playerBoard.decreaseFirePower(1);
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
}