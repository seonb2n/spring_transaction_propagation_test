# Transaction Propagation 레벨 설정에 따른 rollback 테스트를 진행했습니다.

- Transaction Manager 와 Propagation 에 대한 공부를 바탕으로 테스트를 수행했습니다.
<br/>
https://blog.naver.com/626ksb/223262091336
<br/>
https://blog.naver.com/626ksb/223258571858

- propagation.required 인 경우, 자식 트랜잭션에서 Transaction 예외가 발생하면 부모 또한 롤백됩니다. Catch 로 예외를 처리해주더라도 롤백이 수행됩니다.
- propagation.requires_new 인 경우, 자식 트랜잭션에서 예외가 발생하고, 부모가 try catch 로 예외 처리를 해주는 경우엔, 롤백이 자식만 수행됩니다.
