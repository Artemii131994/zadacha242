package securitis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import securitis.service.UserServiceDao;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserServiceDao userServiceDao; // сервис, с помощью которого тащим пользователя
    private final SuccessUserHandler successUserHandler; // класс, в котором описана логика перенаправления пользователей по ролям

    @Autowired
    public WebSecurityConfig(UserServiceDao userServiceDao, SuccessUserHandler successUserHandler) {
        this.userServiceDao = userServiceDao;
        this.successUserHandler = successUserHandler;

    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication().withUser("ADMIN").password("ADMIN").roles("ADMIN");
        auth.userDetailsService(userServiceDao).passwordEncoder(passwordEncoder());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
////        http.formLogin()
////                // указываем страницу с формой логина
////                .loginPage("/login")
////                //указываем логику обработки при логине
////                .successHandler(new securitis.security.SuccessUserHandler())
////                // указываем action с формы логина
////                .loginProcessingUrl("/login")
////                // Указываем параметры логина и пароля с формы логина
////                .usernameParameter("j_username")
////                .passwordParameter("j_password")
////                // даем доступ к форме логина всем
////                .permitAll();
////        http.logout()
////                // разрешаем делать логаут всем
////                .permitAll()
////                // указываем URL логаута
////                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////                // указываем URL при удачном логауте
////                .logoutSuccessUrl("/login?logout")
////                //выклчаем кроссдоменную секьюрность (на этапе обучения неважна)
////                .and().csrf().disable();
////        http
////                // делаем страницу регистрации недоступной для авторизированных пользователей
////                .authorizeRequests()
////                //страницы аутентификаци доступна всем
////                .antMatchers("/login").anonymous()
////                // защищенные URL
////                .antMatchers("/").permitAll()
////                .antMatchers("/user")
////                .access("hasAnyRole('ROLE_USER')")
////                .antMatchers("/admin/**")
////                .access("hasAnyRole('ROLE_ADMIN')")
////                .anyRequest().authenticated();
////    }
////        http.csrf().disable();
////        http.authorizeRequests().antMatchers("/login").anonymous()
////                .antMatchers("/","/admin").hasAnyAuthority("ADMIN","USER")
////                .antMatchers("/","/user").hasAnyAuthority("ADMIN", "USER")
////                .anyRequest().authenticated().and().formLogin().successHandler(new SuccessUserHandler());
////        http.logout().permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").and().csrf().disable();
////    }
//
//        http.formLogin()
//                // указываем страницу с формой логина
////                //указываем логику обработки при логине
//                .successHandler(new SuccessUserHandler())
////                // указываем action с формы логина
////                .loginProcessingUrl("/login")
//                // Указываем параметры логина и пароля с формы логина
//                .usernameParameter("j_username")
//                .passwordParameter("j_password")
//                // даем доступ к форме логина всем
//                .permitAll();
//
//        http.logout()
//                // разрешаем делать логаут всем
//                .permitAll()
//                // указываем URL логаута
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                // указываем URL при удачном логауте
//                .logoutSuccessUrl("/")
//                //выклчаем кроссдоменную секьюрность (на этапе обучения неважна)
//                .and().csrf().disable();
//
//        http
//                // делаем страницу регистрации недоступной для авторизированных пользователей
//                .authorizeRequests()
//                //страницы аутентификаци доступна всем
//                .antMatchers("/login").anonymous()
//                // защищенные URL
//                .antMatchers("/admin/**").access("hasRole('ADMIN')")
//                .antMatchers("/user/**").access("hasAnyRole('ADMIN','USER')")
//                .anyRequest().authenticated();
//    }
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/login").anonymous()
                .antMatchers("/","/admin").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/","/user").hasAnyAuthority("ADMIN", "USER")
                .anyRequest().authenticated().and().formLogin().successHandler(new SuccessUserHandler());
        http.logout().permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").and().csrf().disable();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();

    }
    @Bean
    protected DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userServiceDao);
        return daoAuthenticationProvider;
    }

//    private final UserDetailsService userDetailsService;
//    private final SuccessUserHandler successUserHandler;
//    @Autowired
//    public WebSecurityConfig(UserDetailsService userDetailsService, SuccessUserHandler successUserHandler) {
//        this.userDetailsService = userDetailsService;
//        this.successUserHandler = successUserHandler;
//    }
//
//    @Bean
//    protected DaoAuthenticationProvider daoAuthenticationProvider(){
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
//        return daoAuthenticationProvider;
//    }
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(daoAuthenticationProvider());
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }

}
