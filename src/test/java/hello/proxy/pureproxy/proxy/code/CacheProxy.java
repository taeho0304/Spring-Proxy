package hello.proxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject{

    /** 클라이언트가 프록시를 호출하면 프록시가 최종적으로 실제 객체를 호출해야한다.
     *  이렇게 프록시가 호출하는 대상을 target이라 한다.
     */
    private Subject target;
    private String  cacheValue;

    public CacheProxy(Subject target) {
        this.target = target;
    }

    /**
     * 만역 cacheValue에 값이 있으면 실제 객체를 전혀 호출하지 않고,
     * 캐시 값을 그대로 반환한다.
     * 따라서 처음 조회 이후에는 캐시에서 매우 빠르게 데이터를 조회할 수 있다.
     * */
    @Override
    public String operation() {
        log.info("프록시 호출");
        if(cacheValue ==null){
            cacheValue = target.operation();
        }
        return null;
    }
}
