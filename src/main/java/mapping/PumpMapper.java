package mapping;

public class PumpMapper {
    public PumpDto map(Pump pump) {
        PumpDto pumpDto = new PumpDto();
        Integer fieldA = pump.getA().orElseThrow(() -> new RuntimeException("field a absent"));

        pumpDto.setA(fieldA.toString());
        pumpDto.setB(pumpDto.getB());
        return pumpDto;
    }
}