@extends('layout.app')

@section('content')
    <section class="welcome">
        @include('components.home_presentation')
    </section>

       @include('components.home_faq')
    
       @include('components.home_history')
    
    
@endsection
