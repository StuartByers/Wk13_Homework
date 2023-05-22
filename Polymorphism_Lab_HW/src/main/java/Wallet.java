import java.util.ArrayList;
import java.util.List;

class Wallet {
    private final List<IChargeable> chargeables;
    private IChargeable selectedChargeable;

    public Wallet() {
        this.chargeables = new ArrayList<>();
        this.selectedChargeable = null;
    }

    public void addChargeable(IChargeable chargeable) {
        chargeables.add(chargeable);
    }

    public List<IChargeable> getChargeables() {
        return chargeables;
    }

    public IChargeable getSelectedChargeable() {
        return selectedChargeable;
    }

    public void selectChargeable(int index) {
        if (index >= 0 && index < chargeables.size()) {
            selectedChargeable = chargeables.get(index);
        }
    }

    public void pay(double amount) {
        if (selectedChargeable != null) {
            selectedChargeable.charge(amount);
        }
    }
}