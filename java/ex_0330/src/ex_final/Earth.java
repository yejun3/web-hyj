package ex_final;

public class Earth {
	
	// 지구 반지름
	//상수 선언 및 초기화
	static final double EARTH_RADIUS =6400;
	
	//상수 선언하고 상수 초기화
	static final double EARTH_SURFACE_AREA;
	static {
		EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
		}

}
