package newpumpbutchselector;

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
public class CirculationPumpResponse {
    private Pump pumpOrNull;
    private String model;
    private PumpRequest request;
    private CirculationPumpSelectorException error;
    private CirculationPumpWorkPoint workPoint;

    public CirculationPumpResponse(Pump pump, PumpRequest request) {
        this.request = request;
        this.pumpOrNull = pump;
        this.model = pump.getModel();
        ;
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
        for (Pump.Speed speed : pumpOrNull.getSpeeds()) {
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

    public Pump getPumpOrNull() {
        return pumpOrNull;
    }

    public void setPumpOrNull(Pump pumpOrNull) {
        this.pumpOrNull = pumpOrNull;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public PumpRequest getRequest() {
        return request;
    }

    public void setRequest(PumpRequest request) {
        this.request = request;
    }

    public CirculationPumpSelectorException getError() {
        return error;
    }

    public void setError(CirculationPumpSelectorException error) {
        this.error = error;
    }

    public CirculationPumpWorkPoint getWorkPoint() {
        return workPoint;
    }

    public void setWorkPoint(CirculationPumpWorkPoint workPoint) {
        this.workPoint = workPoint;
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
