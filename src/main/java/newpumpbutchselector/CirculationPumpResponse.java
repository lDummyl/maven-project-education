package newpumpbutchselector;

import lombok.Getter;
import lombok.Setter;
import newpumpselector.CirculationPumpSelectorException;
import task7.Pump;
import task8.PumpRequest;

import java.util.Optional;

/*
	Реализовать пакетный подбор насосов
	создать генератор Json, который содержит пары расход/напор
	принимать его на вход и выдавать json в виде отчета: насос, входные параметры,
	рабочая точка модель, первый технический блок
	второй блок коммерческий, список уникальных моделей, их количество цена за штуку/сумму
	плюс всего за предложение, с доставкой(отдельно) 10% от стоимости, при стоиомсти выше 10 000
	доставка бесплатно.
 */
@Getter
@Setter
public class CirculationPumpResponse {
    private Optional<Pump> pump;
    private String model;
    private PumpRequest request;
    private CirculationPumpSelectorException error;
    private CirculationPumpWorkPoint workPoint;

    public CirculationPumpResponse(Pump pump, PumpRequest request) {
        this.request = request;
        this.pump = Optional.of(pump);
        this.model = pump.getModel();
        this.workPoint = workPointSearch();
    }

    public CirculationPumpResponse(PumpRequest request) {
        this.request = request;
    }

    public CirculationPumpResponse(CirculationPumpSelectorException e) {
        this.error = e;
    }

    private CirculationPumpWorkPoint workPointSearch() {

        Pump.Speed workSpeed = null;
        for (Pump.Speed speed : pump.get().getSpeeds()) {
            Double pressureValue = speed.getPressureValue(request.getConsumption());
            if (pressureValue >= request.getPressure()) {
                workSpeed = speed;
                break;
            }
        }
        assert workSpeed != null;
        Double consumptionValue = workSpeed.getConsumptionValue(request.getPressure());
        return new CirculationPumpWorkPoint(consumptionValue, request.getPressure());
    }


    private static class CirculationPumpWorkPoint {
        private Double consumption;
        private Double pressure;

        public CirculationPumpWorkPoint(Double consumption, Double pressure) {
            this.consumption = consumption;
            this.pressure = pressure;
        }

        public Double getConsumption() {
            return consumption;
        }

        public void setConsumption(Double consumption) {
            this.consumption = consumption;
        }

        public Double getPressure() {
            return pressure;
        }

        public void setPressure(Double pressure) {
            this.pressure = pressure;
        }
    }
}
