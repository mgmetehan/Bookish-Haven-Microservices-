# Bookish-Haven-Microservices

@CircuitBreaker(name = "book-service", fallbackMethod = "fallback") ile 
hata durumunda fallback methodu ?al??t?r?l?r. Tek problem bu methodun error decoder
ile ?al??mamas?. Iki durumdan birini se?mek gerekiyor. Ya error decoder ile ?al??acak
ya da fallback methodu ile.