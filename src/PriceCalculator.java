public class PriceCalculator implements Visitor {

    public double tmpPrice;
    public static String hItem;

    @Override
    public void visitGlass(Glass g) {
        if (g.getTickness() == 1) {
            tmpPrice = ((g.getLenght()-g.getLenght()%100)/100)*2;
        } else if (g.getTickness() == 2) {
            tmpPrice = ((g.getLenght()-g.getLenght()%100)/100)*1.2;
        } else {
            tmpPrice = ((g.getLenght()-g.getLenght()%100)/100)*0.7;
        }
        hItem = g.getName();
    }

    @Override
    public void visitFurniture(Furniture f) {
        tmpPrice = 5*((f.getWeight()-(f.getWeight()%20))/20);
        hItem = f.getName();
    }

    @Override
    public void visitElectronic(Electronic e) {
        if (e.getFragile()) {
            tmpPrice = 0.5*e.getWeight();
        } else {
            tmpPrice = 0.33333*e.getWeight();
        }
        hItem = e.getName();
    }

    public double getPrice(HouseholdItem h) {
        tmpPrice = 0;
        h.accept(this);
        return tmpPrice;
    }

}
