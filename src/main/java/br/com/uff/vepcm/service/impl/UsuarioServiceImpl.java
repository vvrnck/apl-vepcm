package br.com.uff.vepcm.service.impl;

import br.com.uff.vepcm.domain.entity.Pessoa;
import br.com.uff.vepcm.domain.entity.Usuario;
import br.com.uff.vepcm.domain.repository.PessoaRepository;
import br.com.uff.vepcm.domain.repository.UsuarioRepository;
import br.com.uff.vepcm.service.PessoaService;
import br.com.uff.vepcm.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Transactional
    @Override
    public Usuario salvarUsuario(@Valid Usuario usuario) {
        usuario.setSenha(encoder.encode(usuario.getSenha()));
//        usuario.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.buscarPorEmail(email);
    }

    @Override
    public List<Usuario> buscarTodosVendedores() {
        return usuarioRepository.buscarTodosVendedores();
    }

    @Transactional
    @Override
    public Usuario alterarUsuario(Long id, Usuario usuarioAlterado) {
        Usuario usuario = buscarPorId(id);
        if (Objects.isNull(usuario)) return null;
        if (Objects.nonNull(usuarioAlterado.getEmail())) usuario.setEmail(usuarioAlterado.getEmail());
        if (Objects.nonNull(usuarioAlterado.getSenha())) usuario.setSenha(usuarioAlterado.getSenha());
//        if (Objects.nonNull(usuarioAlterado.getPessoa())) {
//            //usuario.setPessoa(usuarioAlterado.getPessoa());
//            Pessoa pessoaAlterada = usuarioAlterado.getPessoa();
//            PessoaServiceImpl p = new PessoaServiceImpl();
//            Pessoa pessoa = p.buscarPessoaPorId(pessoaAlterada.getId());
//            System.out.println(pessoa);
//            pessoa.setIdentidade(pessoaAlterada.getIdentidade());
//            pessoa.setCpf(pessoaAlterada.getCpf());
//            p.salvarPessoa(pessoa);
//        }
        if (Objects.nonNull(usuarioAlterado.getPessoa())) usuario.setPessoa(usuarioAlterado.getPessoa());
        return salvarUsuario(usuario);
    }

    @Transactional
    @Override
    public void removerUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

}
