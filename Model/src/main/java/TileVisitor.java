public interface TileVisitor {
    void visit(Shield shield);

    void visit(Drill drill);
    void visit(HousingUnit housingUnit);
    void visit(Heater heater);
    void visit(PowerCenter powerCenter);
    void visit(Pipe pipe);
    void visit(Storage storage);
    void visit(CentralHousingUnit centralHousingUnit);
    void visit(AlienAddOn alienAddOn);
}
