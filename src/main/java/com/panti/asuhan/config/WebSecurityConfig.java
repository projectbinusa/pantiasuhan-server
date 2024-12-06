package com.panti.asuhan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private UserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    private static final String[] AUTH_WHITELIST = {
            // -- Swagger UI v2
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            // -- Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**",
            "/swagger-ui/**",
            // API controller
            "/login", "/register",
            "/pantiasuhan/api/alumni/all/**",
            "/pantiasuhan/api/alumni/get/**",
            "/pantiasuhan/api/berita/all/**",
            "/pantiasuhan/api/berita/get/**",
            "/pantiasuhan/api/berita/terbaru",
            "/pantiasuhan/api/berita/search",
            "/pantiasuhan/api/berita/arsip",
            "/pantiasuhan/api/berita/by-category",
            "/pantiasuhan/api/berita/related-berita/by-id-berita",
            "/pantiasuhan/api/berita/terbaru-by-category",
            "/pantiasuhan/api/ekstrakulikuler/all/**",
            "/pantiasuhan/api/ekstrakulikuler/get/**",
            "/pantiasuhan/api/foto_kegiatan/all/**",
            "/pantiasuhan/api/foto_kegiatan/get/**",
            "/pantiasuhan/api/foto_sarana/all/**",
            "/pantiasuhan/api/foto_sarana/get/**",
            "/pantiasuhan/api/galeri/all/**",
            "/pantiasuhan/api/galeri/get/**",
            "/pantiasuhan/api/guru/all/**",
            "/pantiasuhan/api/guru/get/**",
            "/pantiasuhan/api/kegiatan/all/**",
            "/pantiasuhan/api/kegiatan/get/**",
            "/pantiasuhan/api/keuangan/all/**",
            "/pantiasuhan/api/keuangan/get/**",
            "/pantiasuhan/api/keuangan/category",
            "/pantiasuhan/api/kontak/all/**",
            "/pantiasuhan/api/kontak/get/**",
            "/pantiasuhan/api/prestasi/all/**",
            "/pantiasuhan/api/prestasi/get/**",
            "/pantiasuhan/api/program/all/**",
            "/pantiasuhan/api/program/get/**",
            "/pantiasuhan/api/sambutan/all/**",
            "/pantiasuhan/api/sambutan/get/**",
            "/pantiasuhan/api/sarana/all/**",
            "/pantiasuhan/api/sarana/get/**",
            "/pantiasuhan/api/sejarah/all/**",
            "/pantiasuhan/api/sejarah/get/**",
            "/pantiasuhan/api/struktur/all/**",
            "/pantiasuhan/api/struktur/get/**",
            "/pantiasuhan/api/tenaga_kependidikan/all/**",
            "/pantiasuhan/api/tenaga_kependidikan/get/**",
            "/pantiasuhan/api/visiMisi/all/**",
            "/pantiasuhan/api/visiMisi/get/**",
            "/pantiasuhan/api/kotak_saran/add",
            "/pantiasuhan/api/perpustakaan/get/**",
            "/pantiasuhan/api/perpustakaan/all/**",
            "/pantiasuhan/api/materi_ajar/get/**",
            "/pantiasuhan/api/materi_ajar/all/**",
            "/pantiasuhan/api/kondisi_sekolah/all/**",
            "/pantiasuhan/api/kondisi_sekolah/get/**",
            "/pantiasuhan/api/osis/all/**",
            "/pantiasuhan/api/osis/get/**",
            "/pantiasuhan/api/category_program/all/**",
            "/pantiasuhan/api/category_program/get/**",
            "/pantiasuhan/api/category_program/all/terbaru/**",
            "/pantiasuhan/api/program/all/terbaru/**",
    };

    private static final String[] AUTH_AUTHORIZATION = {
            "/bawaslu/api/berita/**",
            "/bawaslu/api/pengumuman/**",
            "/bawaslu/api/isi-keterangan-informasi/**",
            "/bawaslu/api/jenis-informasi/**",
            "/bawaslu/api/jenis-keterangan/**",
            "/bawaslu/api/permohonan-informasi/**",
            "/bawaslu/api/permohonan-keberatan/**",
            "/bawaslu/api/tags/**",
            "/bawaslu/api/jenis-regulasi/**",
            "/bawaslu/api/menu-regulasi/**",
            "/bawaslu/api/regulasi/**",
            "/bawaslu/api/category-berita/**",
            "/bawaslu/api/tabel-regulasi/**",
            "/bawaslu/api/tabel-dip/**",
            "/bawaslu/api/tabel-sop/**",
            "/bawaslu/api/carousel/**",
            "/bawaslu/api/library/**",
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers(AUTH_AUTHORIZATION).hasRole("ADMIN")
                .antMatchers(AUTH_AUTHORIZATION).hasAnyRole( "ADMIN")
                .anyRequest()
                .authenticated().and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);


        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}