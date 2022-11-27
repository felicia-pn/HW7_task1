public class PackingInstruction implements Visitor {
    public String coverType;
    public int dim1;
    public int dim2;
    public int dim3;

    public String instruction;

    @Override
    public void visitGlass(Glass g) {
        coverType = "Bubble wraps";
        dim1 = g.getHeight()+1;
        dim2 = g.getLenght()+1;
        dim3 = g.getWidth()+1;
        instruction = "should be covered with " + coverType + " and packed in a box with dimension: " + dim1+"x"+dim2+"x"+dim3;
    }

    @Override
    public void visitFurniture(Furniture f) {
        coverType = "waterproof covers";
        dim1 = f.getLenght();
        dim2 = f.getWidth();
        instruction = "should be covered with " + coverType + " and packed in a box with area of: " + dim1+"x"+dim2;
    }

    @Override
    public void visitElectronic(Electronic e) {
        coverType = "Polyethylene";
        dim1 = e.getHeight()+1;
        dim2 = e.getLenght()+1;
        dim3 = e.getWidth()+1;
        instruction = "should be covered with " + coverType + " and packed in a box with dimension: " + dim1+"x"+dim2+"x"+dim3;
    }

    public String getInstruction(HouseholdItem h) {
        coverType = "undef";
        dim1 = 0;
        dim2 = 0;
        dim3 = 0;
        h.accept(this);
        return instruction;
    }

}
