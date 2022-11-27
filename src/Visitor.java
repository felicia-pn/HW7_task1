public interface Visitor {

    default void visitGlass(Glass g) {
    }

    default void visitFurniture(Furniture f) {
    }

    default void visitElectronic(Electronic e) {
    }

}
